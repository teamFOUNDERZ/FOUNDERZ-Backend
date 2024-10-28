dependencies {
    api (project(":founderz-application:user-application"))
    api (project(":founderz-application:auth-application"))
}

subprojects {
    dependencies {
        implementation(project(":founderz-common"))
    }
}