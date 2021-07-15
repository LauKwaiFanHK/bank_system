#!/bin/bash
bad_choice=true
echo "Type 'standard' to run standard to run standard version or 'pro' to run professional version"

while $bad_choice; do
	read choice
	if [ "$choice" = "standard" ]; then
		bad_choice=false
		java -jar build/libs/StandardVersion.jar
	elif  [ "$choice" = "pro" ]; then
		bad_choice=false
		java -jar build/libs/ProfessionalVersion.jar
	else
		echo "Incorrect input, type 'standard' or 'pro'"
	fi
done

echo "Goodbye!"