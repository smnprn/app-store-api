<!-- PROJECT LOGO -->
<br />
<div align="center">
    <a href="https://github.com/smnprn/app-store-api">
        <img src="/src/main/resources/readme/app-store.png" alt="logo" width="80" height="80">
    </a>
    <h2 align="center"><b>App Store API</b></h2>
    <p align="center">
        <a href="https://github.com/smnprn/app-store-api/issues">Report a bug</a>
        -
        <a href="https://github.com/smnprn/app-store-api/issues">Request feature</a>
    </p>
</div>

<!-- TABLE OF CONTENTS -->

<!-- About -->
## About the project
This project provides a REST API for retrieving information about apps in the Apple App Store.  
Currently, the database holds data for over 1 million apps for which you can access detailed information including
name, price, ratings and more.

<b>Important note:</b>
This API is unofficial and not endorsed by Apple.
Copyright rights belong to the legitimate owners.


### Built with
![Java][java-logo] <br>
![Spring][spring-boot-logo] <br>
![MySQL][mysql-logo]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Getting Started -->
## Get app information

The app information endpoint is available at `/api/v0.1/apps` and the developer information endpoint is at `/api/v0.1/developers`, both accept GET requests. </br>
You can pass multiple parameters to these endpoints to filter the information returned: </br> </br>
`App endpoint` </br>
* **id** - Unique id for every app database entry
* **appid** - App id on the App Store
* **name** - Name of the app
* **url** - URL of the app on the App Store
* **genre** - App genre (e.g. Education, Book, Lifestyle)
* **rating** - Content rating (e.g. 4+, 12+, 18+)
* **size** - App size in bytes
* **ios** - Required iOS version
* **price** - Price of the app
* **currency** - Currency of the price
* **free** - Value 1 is for free apps, value 0 is for paid apps
* **developer** - Id of the app developer
* **rating** - Average user rating
* **reviews** - Number of reviews

`Developer endpoint`
* **id** - Id of the app developers
* **name** - Developer name
* **url** - Developer URL on the App Store
* **website** - Developer own website

The API response will contain all the information for the apps or developers that correspond to the query parameters.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!--Auth-->
## Authentication
To use the API you should register first by sending a POST request to the `/api/v0.1/registration` endpoint:

    http POST .../api/v0.1/registration firstName="name" lastName="surname" email="email" password="password"

If your request is successful a confirmation email will be sent to the email address provided. 
Alternatively, you can confirm your account by sending a GET request including your confirmation token:

    http GET .../api/v0.1/registration/confirm?token=your_confirmation_token

After confirming your account you can request a bearer token to authenticate your app and developer requests:

    http POST .../api/v0.1/token --auth email:password

You must include the bearer token in every request to the `.../apps` and `.../developers` endpoints:

    http GET .../api/v0.1/apps?name=Facebook 'Authorization: Bearer your_bearer_token'

**NOTE**: the confirmation token expires in 15 minutes, the bearer token expires in 1 hour.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Usage -->
## Example Usage
Get all the paid social network apps:


    http GET .../api/v0.1/apps?free=0&genre=Social%20Networking 'Authorization: Bearer your_bearer_token'
Get all the info about the developer whose name is 'Google LLC':


    http GET .../api/v0.1/developers?name=Google%20LLC 'Authorization: Bearer your_bearer_token'

<div align="center">

</div>


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Contributing -->
## Contributing
If you wish to contribute to the project <b>feel free to fork the repo and create a pull request</b>!\
You can report a bug opening an "issue" here on GitHub.
Any contribution you make is greatly appreciated.\
<b>Thank you!</b>

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/YourFeature`)
3. Commit your Changes (`git commit -m 'add: added feature'`)
4. Push to the Branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- License -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Simone Perna - simoneperna8@gmail.com

If you wish, feel free to write me a message on GitHub!

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
[preview-image]: images/preview.png
[java-logo]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=coffeescript&logoColor=white
[java-url]: www.java.com
[spring-boot-logo]: https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[spring-boot-url]: https://spring.io/projects/spring-boot
[mysql-logo]: https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white
[mysql-url]: https://www.mysql.com/it/