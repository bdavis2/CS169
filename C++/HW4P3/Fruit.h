#pragma once
#ifndef FRUIT_H
#define FRUIT_H

#include "Food.h"
#include "Date.h"

class Fruit : virtual public Food {
private:
	Date ripe;
public:
	Fruit() : Food()
	{
		std::cout << "Fruit()" << std::endl;
		ripe = Date();
	}
	Fruit(Date r, std::string iname) :
		Food(iname)
	{
		std::cout << "Fruit(r, iname)" << std::endl;
		ripe = r;
	}
	virtual void ripeTime() {
		std::cout << "you can eat it on " + std::to_string(ripe.getDate()) << std::endl;
	}
};
#endif //FRUIT_H