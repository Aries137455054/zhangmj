package wymb.web.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MyWebSocketHandler implements WebSocketHandler {

	private static final Logger log = Logger.getLogger(MyWebSocketHandler.class);
	//保存所有用户的session
	private static final List<WebSocketSession> users = new ArrayList<WebSocketSession>();
	
	//关闭连接时
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("关闭连接");
		users.remove(session);
	}

	//连接就绪时
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("******************************Connect webSocket success");
		users.add(session);
	}

	//处理信息
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		Gson gson = new Gson();
		Map<String,Object> msg = gson.fromJson(message.getPayload().toString(), new TypeToken<Map<String,Object>>(){}.getType());
		System.err.println("handleMessage......."+message.getPayload()+"..........."+msg);
		TextMessage textMessage = new TextMessage(msg.get("msgContent").toString(),true);
		sendMsgToAllUsers(textMessage);
	}

	//处理传输异常
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		
	}

	public boolean supportsPartialMessages() {
		return false;
	}
	
	public void sendMsgToAllUsers(WebSocketMessage<?> message){
		for (WebSocketSession webSocketSession : users) {
			try {
				webSocketSession.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
