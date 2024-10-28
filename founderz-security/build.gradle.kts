val pasetoVersion = "0.7.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("dev.paseto:jpaseto-its:$pasetoVersion")
    implementation(project(":founderz-common"))
    implementation(project(":founderz-domain:user-domain"))
}