cd creditos-backend
mvn clean package
Start-Process -NoNewWindow mvn spring-boot:run
cd ..
cd creditos-frontend
npm install
Start-Process -NoNewWindow -FilePath "npx" -ArgumentList "ng serve"
