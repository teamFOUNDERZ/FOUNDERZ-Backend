val txVersion = "5.3.30";

subprojects {
    dependencies {
        implementation("org.springframework:spring-tx:$txVersion")
        implementation(project(":founderz-common"))
    }
}