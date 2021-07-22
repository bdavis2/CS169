#pragma once
#ifndef APPLE_H
#define APPLE_H

#include "Fruit.h"

class Apple : public Fruit {

public:
	Apple() : Fruit(Date(), "Apple") {};
	Apple(Date id, std::string iname) : Fruit(id, iname) {}
	void prepare() {
		std::cout << "Core the apple" << std::endl;
	}
};
#endif //APPLE_H