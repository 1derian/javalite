package org.javalite.activeweb.websockets;

import org.javalite.json.JSONList;
import org.javalite.json.JSONParseException;

import static org.javalite.json.JSONHelper.toJSONList;

public abstract class JSONListEndpoint extends AppEndpoint {
    @Override
    public void onMessage(String json) {
        try {
            onJSONList(toJSONList(json));
        } catch (JSONParseException ex) {
            throw new WebSocketException("The input is not JSON array.", ex);
        }
    }

    public abstract void onJSONList(JSONList list);
}
