# contactmanagement is a restulf web service implemented using glassfish jersey framework.
# There are create, get, update, and delete methods using put, get, post, and delete HTTP methods respectively.
# 
# The persistency of the contact is in-memory only by using a static hash table.
#
# Upon deployment, the URLs to access the web services are as follows:
#
# to get the contact of given first name and last name
#http://{host}:{port}/{context root}/contact/management/get/{first_name}/{last_name}
#
# to create/add a new contact
#http://localhost:8081/rest/contact/management/create
#
# the pay load should be in json format as follows:
#{
# "FirstName": "{first_name}",
# "LastName": "{last_name",
# "EmailAddress": "{some_email_address}"
#}
# to update a contact
#http://localhost:8081/rest/contact/management/update
#
# the pay load should be in json format as follows:
#{
# "FirstName": "{first_name}",
# "LastName": "{last_name",
# "EmailAddress": "{new_email_address}"
#}
# 
# to delete a contact
#
#http://{host}:{port}/{context root}/contact/management/delete/{first_name}/{last_name}