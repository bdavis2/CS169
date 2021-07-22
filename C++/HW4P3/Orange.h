#pragma once
#ifndef ORANGE_H
#define ORANGE_H

#include "Fruit.h"

class Orange : public Fruit {

public:
	Orange() : Fruit(Date(), "Orange") {
		std::cout << "Orange()" << std::endl;
	};
	Orange(Date r, std::string iname) : Fruit(r, iname){
		std::cout << "Orange(r, iname)" << std::endl;
	}
	void prepare() {
		std::cout << "Peel the orange" << std::endl;
	}
};
#endif //ORANGE_H