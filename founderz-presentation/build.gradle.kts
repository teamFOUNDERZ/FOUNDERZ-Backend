dependencies {
    api (project(":founderz-presentation:auth-presentation"))
    api (project(":founderz-presentation:user-presentation"))
}

allprojects {
    dependencies {
        implementation(project(":founderz-common"))
    }
}