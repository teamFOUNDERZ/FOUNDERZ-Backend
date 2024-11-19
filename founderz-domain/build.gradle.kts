subprojects {
    val useMySQL: Boolean by extra(false)
    val useRedis: Boolean by extra(false)

    afterEvaluate {
        dependencies {
            implementation(project(":founderz-common"))

            if (useMySQL) {
                implementation("org.springframework.boot:spring-boot-starter-data-jpa")
                runtimeOnly("com.mysql:mysql-connector-j")
            }
            if (useRedis) {
                implementation("org.springframework.boot:spring-boot-starter-data-redis")
            }
        }
    }
}