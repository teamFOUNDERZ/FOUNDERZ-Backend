dependencies {
    api (project(":founderz-presentation:auth-presentation"))
    api (project(":founderz-presentation:user-presentation"))
    api (project(":founderz-presentation:tag-presentation"))
    api (project(":founderz-presentation:sector-presentation"))
    api (project(":founderz-presentation:userinterest-presentation"))
    api (project(":founderz-presentation:business-presentation"))
    api (project(":founderz-presentation:investment-presentation"))
}

allprojects {
    dependencies {
        implementation(project(":founderz-common"))
        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
        if (project.name != ("common-presentation")) {
            implementation(project(":founderz-presentation:common-presentation"))
        }
    }
}