
SELECT * FROM event WHERE  JSON_EXTRACT(eventdoc, "$.exitCode") = 'OK' ;  

SELECT * FROM event WHERE  JSON_EXTRACT(eventdoc, "$.details.itemId") = 'THX-1138';

SELECT * FROM event WHERE  JSON_EXTRACT(eventdoc, "$.identity") = '3eb83bbbe01eeed563cb22bb8f5acdc8';

SELECT * FROM event WHERE  JSON_SEARCH(eventdoc, 'all', '%2250%')  IS NOT NULL;

SELECT * FROM event WHERE JSON_CONTAINS_PATH(eventdoc, 'one', "$.referer"); 

SELECT * FROM event WHERE JSON_CONTAINS_PATH(eventdoc, 'one', "$.payload.matrix[*].status"); 

SELECT * FROM event WHERE  JSON_EXTRACT(eventdoc, "$.eventBody.details.cartId") = 'LUH-9021';

   