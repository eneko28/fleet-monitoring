import requests
import random

# The url of the backend REST API
api_url = "http://backend:8080/api/v1/machine"
# The list of IDs that will be used for the test
id_list = [112, 358, 132, 134]

# Print the content of the DB
response = requests.get(api_url)
print("All the machines in the DB are: " + str(response.json()))
print()
print()

val = "a"
while val != "e":

    # Select the id randomly and get the machine with the selected ID
    id = id_list[random.randrange(10)%len(id_list)]
    response = requests.get(api_url + "/" + str(id))
    
    # If there is no machine with such ID
    if response.status_code == 500:
        # Create new machine with the selected id, and a preselected version
        print("There is no machine with id " + str(id) + "... Creating new one")
        data = {"id":str(id), "version":"10"}
        response = requests.post(api_url,json=data)

        # Ask the user the location of the machine and modify the existing DB entry with the new value
        # Note: in the current backend implementation, two machines cannot be in the same location
        location = input('Enter the location: ')
        response = requests.put(api_url + "/" + str(id),{"location":location})
        print("Setting the location")
    else:
        # Delete the machine with the selected id
        print("There is a machine with id " + str(id) + "... Deleting it")
        response = requests.delete(api_url + "/" + str(id))
    
    # Print the new content of the DB
    response = requests.get(api_url)
    print("All the machines in the DB are: " + str(response.json()))

    # Ask the user if they want to continue testing the backend or not
    # Press touch e to exit, any other to continue
    print()
    val = input('> Press e to exit, any other touch to continue testing... ')
    print()
    print()



    
