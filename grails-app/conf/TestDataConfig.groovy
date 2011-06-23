testDataConfig {
	sampleData {
		'com.loopback.User' {
			Random rand = new Random()
			username = {->
				def randomKey = rand.nextInt()
				"user-$randomKey@example.com"
			}
		}
	}
}