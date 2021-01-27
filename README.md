# Selenium-TestNG-Docker



To Run in local : change the below testconfig.properties file 
1.environment:local
2.Browser
To Run in remote : change below
environment:remote
browser

# For the docker implementation do below

1- Install docker , 
2. Install docker images for Selenium and all

1.docker run -d -p 4545:4444 —name selenium-hub selenium/hub
2.docker run -d -P --link  selenium-hub:hub selenium/node-chrome-debug
3.docker run -d -P  --link  selenium-hub:hub selenium/node-firefox-debug

# For local remote run download selenium-standaalone-rc jar file and run the below commands:

for the hub : java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hub-conf.json
for the node : Java-Dwebdriver.chrome.driver="C:\ProgramData\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig win-node-conf.json

you can get these 2 json from he repository




