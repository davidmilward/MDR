<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<b>Add a new Person to the system</b> 
<br/>

<form:form modelAttribute="Person">
  <table>
    <tr>
    <th>Title:<form:errors path="title" cssClass="errors"/></th>
         <form:select path="title" >
                <form:option value="Dr">Dr</form:option>
                <form:option value="Mr">Mr</form:option>
                <form:option value="Ms">Ms</form:option>
                <form:option value="Mrs">Mrs</form:option>
                <form:option value="Miss">Miss</form:option>
           </form:select>
    </tr>
    <tr>
	 <th>
        First name: <form:errors path="firstname" cssClass="errors"/>
        <br/>
        <form:input path="firstname" size="10" maxlength="10"/>
      </th>
    </tr>
    <tr>
	 <th>
        Surname: <form:errors path="surname" cssClass="errors"/>
        <br/>
        <form:input path="surname" size="10" maxlength="20"/>
      </th>
    </tr>
    <tr>
	 <th>
        Other names: <form:errors path="otherNames" cssClass="errors"/>
        <br/>
        <form:input path="otherNames" size="10" maxlength="20"/>
      </th>
    </tr>
    <tr>
	 <th>
        Alias: <form:errors path="alias" cssClass="errors"/>
        <br/>
        <form:input path="alias" size="10" maxlength="20"/>
      </th>
    </tr>
    <!--tr>
	 <th>
        Date of Birth: <form:errors path="dob" cssClass="errors"/>
        <br/>
        <form:input path="dob" size="10" maxlength="10"/> (yyyy-mm-dd)
      </th>
    </tr-->
     <tr>
	 <th>
        Notes: <form:errors path="notes" cssClass="errors"/>
        <br/>
        <form:input path="notes" size="10" maxlength="10"/> (yyyy-mm-dd)
      </th>
    </tr>
    

    <tr>
      <td>
            <p class="submit"><input type="submit" value="Add Person"/></p>
      </td>
    </tr>
  </table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
















