package com.chenwl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseError;
import org.apache.hadoop.hive.ql.parse.ParseException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * HiveQL Parser
 * Input: HiveQL File
 * Output:
 *  | success -> AST JSON
 *  | fail    -> [line, column]: error information
 */
public class HiveQLParser
{
    public static void main( String[] args )
            throws IOException, NoSuchFieldException, IllegalAccessException, ParseException {

        String file = args[0];
        String content = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);

        Gson gson = new GsonBuilder().registerTypeAdapter(ASTNode.class, new ASTNodeSerializer()).create();

        ParseDriver pd = new ParseDriver();

        try {
            ASTNode node = pd.parse(content);
            String json = gson.toJson(node);

            System.out.println(json);
        } catch (ParseException e) {
            Field errorsField = ParseException.class.getDeclaredField("errors");
            errorsField.setAccessible(true);
            ArrayList<ParseError> errors = (ArrayList<ParseError>) errorsField.get(e);

            Field reField = ParseError.class.getDeclaredField("re");
            reField.setAccessible(true);
            RecognitionException re = (RecognitionException) reField.get(errors.get(0));

            String errorMsg = "[" + re.line + "," + re.charPositionInLine + "]: " + e.getMessage();

            System.out.println(errorMsg);

            throw e;
        }
    }

    private static class ASTNodeSerializer implements JsonSerializer<ASTNode> {

        @Override
        public JsonElement serialize(ASTNode astNode, Type type, JsonSerializationContext context) {
            if (astNode == null) {
                return null;
            }

            ArrayList<ASTNode> children = new ArrayList<ASTNode>();
            if (astNode.getChildren() != null) {
                for (Node node : astNode.getChildren()) {
                    children.add((ASTNode) node);
                }
            }

            Token token = astNode.getToken();

            JsonObject elem = new JsonObject();

            elem.addProperty("startIndex", astNode.getTokenStartIndex());
            elem.addProperty("stopIndex", astNode.getTokenStopIndex());
            elem.add("token", token != null ? context.serialize(token): null);
            elem.addProperty("childIndex", astNode.getChildIndex());
            elem.add("children", context.serialize(children));
            elem.addProperty("toString", astNode.toString());
            elem.addProperty("toStringTree", astNode.toStringTree());
            return elem;
        }
    }
}
