dependencies {
    api (project(":founderz-application:user-application"))
    api (project(":founderz-application:auth-application"))
    api (project(":founderz-application:tag-application"))
}

subprojects {
    dependencies {
        implementation(project(":founderz-common"))
    }
}