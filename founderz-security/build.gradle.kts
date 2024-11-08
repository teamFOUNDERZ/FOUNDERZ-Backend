val pasetoVersion = "0.7.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("dev.paseto:jpaseto-api:$pasetoVersion")
    implementation("dev.paseto:jpaseto-impl:$pasetoVersion")
    implementation("dev.paseto:jpaseto-jackson:$pasetoVersion")
    implementation("dev.paseto:jpaseto-bouncy-castle:$pasetoVersion")
    implementation(project(":founderz-common"))
    implementation(project(":founderz-domain:user-domain"))
    implementation("org.springframework.boot:spring-boot-starter-aop")
}