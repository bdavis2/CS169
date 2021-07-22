#pragma once

#ifndef TOMATO_H
#define TOMATO_H
#include "Vegetable.h"
#include "Fruit.h"
class Tomato: public Vegetable, public Fruit {
public:
	Tomato() : Fruit(), Vegetable() {
		std::cout << "Tomato()" << std::endl;
	}
	Tomato(Date e, Date r, std::string n) : Fruit(r, n), Vegetable(n,e), Food(n) {
		std::cout << "Tomato(e, r, n)" << std::endl;
	}
};

#endif //TOMATO_H