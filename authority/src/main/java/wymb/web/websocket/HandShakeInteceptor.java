package wymb.web.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandShakeInteceptor extends HttpSessionHandshakeInterceptor {

	//握手前
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
			Map<String, Object> map) throws Exception {
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥握手前");
		return super.beforeHandshake(request, response, handler, map);
	}

	//握手后
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥握手后");
		super.afterHandshake(request, response, wsHandler, ex);
	}
	
	

	
}
