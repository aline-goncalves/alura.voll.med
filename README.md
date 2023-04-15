# alura.voll.med

This project's objective is create a Java Spring Boot API. So, doctor's, patient's and appointment's CRUD was developed for practice.

It was made based on [Spring Boot 3: desenvolva uma API Rest em Java](https://www.alura.com.br/curso-online-spring-boot-3-desenvolva-api-rest-java) Alura's course.

There are some problems with this application witch are:
  - the DELETE requests (405 - method not allowed);
  - non normalization from database (should be an addresses table, for example);
  - code repetition (if there were a class called person for patients and doctors extend for it, for example, would avoid duplicated attributes on this classes);
  - there is no error treatment.
  
Also there are some functions not implemented: 
  - schedule appointments;
  - cancel appointments.

[Project's Trello Board](https://trello.com/invite/b/JuPU49YW/ATTIea4352ab14fe0fb569deb4161faf6d6f1E9DB768/aluravollmedapi)

[Project's Figma](https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007&t=G2nzmzUUqDRuElYT-0)
