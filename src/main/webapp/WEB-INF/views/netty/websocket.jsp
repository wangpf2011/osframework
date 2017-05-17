<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String socPath="ws://"+request.getServerName()+":9688/websocket";  
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath}/static/jquery/1.9.1/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/jquery/jquery-migrate-1.1.1.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/jquery/jquery.jqprint-0.3.js" type="text/javascript"></script>
		<script type="text/javascript">
			var wsuri = "<%=socPath%>";  
	        var ws = null;
	        $(document).ready(function(){
				initWebSocket();
			});
	        
	        function initWebSocket() {
				if (!window.WebSocket) {
		            window.WebSocket = window.MozWebSocket;
		        }
				if (window.WebSocket) {
					ws = new WebSocket(wsuri);
					ws.onmessage = function(evt) {
						var data = eval("(" + event.data + ")");
		                console.log("接收数据: " + JSON.stringify(data));
	                };
	                ws.onclose = function(evt) {
	                    console.info(evt);
	                    ws.close();
	                    ws = null;
	                };
	                ws.onopen = function(evt) {
	                    console.info(evt);
	                    var time1 = setInterval('doTimeJob()',1000*10);
	                };
				}else {
					alert("您的浏览器不支持WebSocket！");
				}
	        };
	        
	        //定时任务 10秒一次
	        function doTimeJob(code) {
        	   if(!ws || ws.readyState !== 1) {
        		   clearInterval(timer1);
        		   ws.close();
        		   initWebSocket();
                   return;
               }
        	   sendMsg("10001");
               sendMsg("10002");
               sendMsg("10003");
               sendMsg("10004");
	        }
	        
	        //向服务端请求数据
	        function sendMsg(code) {
	        	var msg = "";
	               if("10001" == code) {
	                   msg = "{code:'10001', ev:'LR83STG67GBS16112'}";
	               }else if("10002" == code) {
	                   msg = "{code:'10002', ev:'LR83STG67GBS16112'}";
	               }else if("10003" == code) {
	                   msg = "{code:'10003', custid:'1'}";
	               }else if("10004" == code) {
	                   msg = "{code:'10004', ev:'LR83STG67GBS16112', type:'batvolt'}";
	               }
	               console.log("发送数据："+msg);
                   ws.send(msg);
	        }
		</script>
	</head>
	<body>
	
	</body>
</html>