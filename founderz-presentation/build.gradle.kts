dependencies {
    api (project(":founderz-presentation:auth-presentation"))
    api (project(":founderz-presentation:user-presentation"))
}

subprojects {
    dependencies {
        implementation(project(":founderz-common"))
    }
}