
Este proyecto fue realizado con el Framework : Playframework para Java

La documentacion del mismo la podemos encontrar en :  https://www.playframework.com/documentation/latest/Home.


## Running
Para correr la app se debe hacer usando : SBT - https://www.scala-sbt.org

Aqui podemos encontrar informacion:
https://www.playframework.com/documentation/2.7.x/Requirements#Verifying-and-installing-sbt

Basicamente es tener un entorno con : java version 1.8

e Instalar SBT :

Linux  - https://www.scala-sbt.org/1.0/docs/Installing-sbt-on-Linux.html
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt

MAC - https://www.scala-sbt.org/1.0/docs/Installing-sbt-on-Mac.html
brew install sbt@1

Luego de esto, debemos correr en consola el siguiente comando

```
sbt run
```
 Con esto tendremos ya corriendo la aplicacion y debemos ir a: http://localhost:9000 
 para poder verla en funcionamiento, una vez asi ya podremos empezar a hacer peticiones a los servicios web del servidor.
 
 En este proyecto solo hay un servicio desarrollado el cual podemos consultarlo atraves de:
 
 URL : http://localhost:9000/time
 Tipo : POST
 body : {
        	"dato1":"18:31:45",
        	"dato2":"+5"
        }
        
 Header: Content-Type - application/json
