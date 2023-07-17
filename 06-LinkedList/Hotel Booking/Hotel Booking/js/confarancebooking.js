function validate(){
    var fname =document.forms.hall_booking.fname.value;
    var lname =document.forms.hall_booking.lname.value;
    var m_number =document.forms.hall_booking.m_number.value;
    var eid =document.forms.hall_booking.eid.value;



    var a = /^[0-9]+$/;
    var b = /^[a-zA-Z0-9]+$/;
    var c = /^[a-zA-Z]+$/;

    var atpos = eid.indexOf("@");       
    var dotpos = eid.lastIndexOf(".");


    if(fname == null || fname == ""){
        alert("First Name cannot be blank");
        document.forms.hall_booking.fname.focus();
        return false;
    }
    if(c.test(document.forms.hall_booking.fname.value)==false){
        alert(" First Name is alphabetic only")
        return false;
    }
    if(lname == null || fname == ""){
        alert("Last Name cannot be blank");
        document.forms.hall_booking.lname.focus();
        return false;
    }
    if(c.test(document.forms.hall_booking.lname.value)==false){
        alert("Last Name is alphabetic only")
        return false;
    }
    if(m_number == null || m_number == ""){
        alert("Name cannot be blank");
        document.forms.hall_booking.m_number.focus();
        return false;
    }
    if(a.test(document.forms.hall_booking.m_number.value)==false){
        alert("Number is Numaric only")
        return false;
    }
    if(eid == null || eid == ""){
        alert("Email ID cannot be blank");
        document.forms.hall_booking.eid.focus();
        return false;
    }
    if(atpos<1||dotpos<atpos+2||dotpos+2>=eid.length){
        alert("Not a valid email address");
        document.forms.hall_booking.eid.focus();
        return false;
    }
}