Feature: Payment Test(DESTA)

Scenario: Valid Test
	Given User berada di page Checkout
	When Melakukan checkout
	And User berada di page payment "Payment Process"
	And User mengisi kartu kredit 1234657891234567
	And User mengisi expired month 12
	And User mengisi expired year cc 2028
	And User mengisi CVVcode 123
	And User melaukukan payment
	Then User mendapatkan validasi "Payment successfull!"
	
Scenario: inValid Test
	Given User berada di page Checkout
	When Melakukan checkout
	And User berada di page payment "Payment Process"
	And User mengisi kartu kredit 123456789
	And User mengisi expired month 12
	And User mengisi expired year cc 2022
	And User mengisi CVVcode 123
	And User melaukukan payment
	Then User mendapatkan notifikasi alert "Check card number is 16 digits!"