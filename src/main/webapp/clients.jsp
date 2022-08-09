<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <link rel="stylesheet" type="text/css" href="css/index_style.css">
<body onload="reaction()">
<div id="main">
    <h2>Welcome!</h2>
    <form id="field" name="field" method="POST">
        <input type="text" placeholder="Name" name="name" id="name_text"><br>
        <input type="text" placeholder="Gender" name="gender" id="gender_text">
        <input type="text" placeholder="Age" name="age" id="age_text"><br>
        <button name="retrieve" class="btn" id="retr_btn" onclick="retr_data()">Retrive</button>
        <button name="index" class="btn" id="home_btn" onclick="window.open('/webapp')">Home</button>
    </form>
</div>
<div class="window" id="result">
    <h2>Results</h2>
    <div id="res_div"><table>
        <tr><th>Name</th><th>Gender</th><th>Age</th></tr>
        <c:forEach items="${rs_list}" var="temp">
        <tr><td>${temp.name}</td><td>${temp.gender}</td><td>${temp.age}</td></tr>
    </c:forEach></table></div>
    <button name="result_btn" class="btn" id="back" onclick="close_window('result')">Back</button>
</div>
<div class="window" id="failed">
    <h2>Opps!</h2>
    <div class="opv">
        <p>Some errors occured.</p>
        <button name="fail_btn" class="btn" id="fail_ok" onclick="close_window('failed')">OK</button>
    </div>
</div>
</body>
</html>
<script src="js/window.js"></script>
<script src="js/btn_action.js"></script>
<script>
    function reaction(){
        if("${save_result}" == -1)open_window("failed");
        if("${save_result}" == 1)open_window("save_suc");
        if("${retr_result}" == -1)open_window("failed");
        if("${retr_result}" == 1)open_window("result");
    }
</script>