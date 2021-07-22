#pragma once

#ifndef FOOD_H
#define FOOD_H
#include <string>
#include <iostream>
class Food {
private:
	std::string name;
	
public:
	Food() {
		std::cout << "Food()" << std::endl;
		name = "";
	}
	Food(std::string iname) {
		std::cout << "Food(iname)" << std::endl;
		name = iname;

	}
	void setName(std::string iname) {
		name = iname;
		return;
	}
	void prepare() {
		std::cout << "prepare the " + name << std::endl;
	}
};

#endif