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
        <button name="save" class="btn" id="save_btn" onclick="save_data()">Save</button>
        <button name="index" class="btn" id="home_btn" onclick="window.open('/webapp')">Home</button>
    </form>
</div>
<div class="window" id="save_suc">
    <h2>Congratulations!</h2>
    <div class="opv">
        <p>Data saved successfully.</p>
        <button name="save_o_btn" class="btn" id="save_suc_ok" onclick="close_window('save_suc')">OK</button>
    </div>
</div>
<div class="window" id="failed">
    <h2>Opps!</h2>
    <div class="opv">
        <p>Some errors occured.</p>
        <button name="fail_btn" class="btn" id="fail_ok" onclick="close_window('failed')">OK</button>
        <button name="index" class="btn" id="home_btn" onclick="window.open('/webapp')">Home</button>
    </div>
</div>
</body>
</html>
<script src="js/window.js"></script>
<script src="js/btn_action.js"></script>
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