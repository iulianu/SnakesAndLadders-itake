<%@ page import="main.java.com.mozaicworks.Game" %>
<html>
<body>
<form action="index.jsp" method="POST">
    <h3>Snakes and ladders</h3>
    </div>
    <div class="player" style="margin-bottom: 20px;">
        <input type="submit" id="rollTheDice" value="Roll the dice"/>
    </div>
    <div style="margin-bottom: 20px;" class="playerStatus">
        <%=Game.aGame().play("1")%>
    </div>
    <h4 style="margin-bottom: 20px;"><%=Game.aGame().status()%></h4>
</form>
</body>
</html>
