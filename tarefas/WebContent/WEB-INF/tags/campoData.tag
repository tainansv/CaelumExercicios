<%@ attribute name="id" required="true" %>
<%@ attribute name="val" required="false" %>

<input type="text" id="${id}" name="${id}" value="${val}" />

<script type="text/javascript">
$("#${id}").datepicker({ changeYear: true , yearRange: "2010:2014", dateFormat:'dd/mm/yy' });

</script>