function validate(){
    var fname =document.forms.room_booking.fname.value;
    var lname =document.forms.room_booking.lname.value;
    var m_number =document.forms.room_booking.m_number.value;
    var eid =document.forms.room_booking.eid.value;
    var rnum =document.forms.room_booking.rnum.value;
    var cnum =document.forms.room_booking.cnum.value;
    var anum =document.forms.room_booking.anum.value;


    var a = /^[0-9]+$/;
    var b = /^[a-zA-Z0-9]+$/;
    var c = /^[a-zA-Z]+$/;

    var atpos = eid.indexOf("@");       
    var dotpos = eid.lastIndexOf(".");

    if(fname == null || fname == ""){
        alert("First Name cannot be blank");
        document.forms.room_booking.fname.focus();
        return false;
    }
    if(c.test(document.forms.room_booking.fname.value)==false){
        alert(" First Name is alphabetic only")
        return false;
    }
    if(lname == null || fname == ""){
        alert("Last Name cannot be blank");
        document.forms.room_booking.lname.focus();
        return false;
    }
    if(c.test(document.forms.room_booking.lname.value)==false){
        alert("Last Name is alphabetic only")
        return false;
    }
    if(m_number == null || m_number == ""){
        alert("Name cannot be blank");
        document.forms.room_booking.m_number.focus();
        return false;
    }
    if(a.test(document.forms.room_booking.m_number.value)==false){
        alert("Number is Numaric only")
        return false;
    }
    if(rnum == null || rnum == ""){
        alert("Name cannot be blank");
        document.forms.room_booking.rnum.focus();
        return false;
    }
    if(a.test(document.forms.room_booking.rnum.value)==false){
        alert("Number is Numaric only")
        return false;
    }
    if(cnum == null || cnum == ""){
        alert("Name cannot be blank");
        document.forms.room_booking.cnum.focus();
        return false;
    }
    if(a.test(document.forms.room_booking.cnum.value)==false){
        alert("Number is Numaric only")
        return false;
    }
    if(anum == null || anum == ""){
        alert("Name cannot be blank");
        document.forms.room_booking.anum.focus();
        return false;
    }
    if(a.test(document.forms.room_booking.anum.value)==false){
        alert("Number is Numaric only")
        return false;
    }

    if(eid == null || eid == ""){
        alert("Email ID cannot be blank");
        document.forms.room_booking.eid.focus();
        return false;
    }
    if(atpos<1||dotpos<atpos+2||dotpos+2>=eid.length){
        alert("Not a valid email address");
        document.forms.room_booking.eid.focus();
        return false;
    }
}