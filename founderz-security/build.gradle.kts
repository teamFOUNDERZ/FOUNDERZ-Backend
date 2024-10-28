dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("dev.paseto:jpaseto-its:0.7.0")
    implementation(project(":founderz-common"))
    implementation(project(":founderz-domain:user-domain"))
}