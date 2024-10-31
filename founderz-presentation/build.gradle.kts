dependencies {
    api (project(":founderz-presentation:auth-presentation"))
    api (project(":founderz-presentation:user-presentation"))
}

allprojects {
    dependencies {
        implementation(project(":founderz-common"))
        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    }
}