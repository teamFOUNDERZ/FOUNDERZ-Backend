dependencies {
    api(project(":founderz-event:userinterest-event"))
    api(project(":founderz-event:sector-event"))
    api(project(":founderz-event:notice-event"))
}

val txVersion = "5.3.30";

subprojects {
    dependencies {
        implementation("org.springframework:spring-tx:$txVersion")
        implementation(project(":founderz-common"))
    }
}