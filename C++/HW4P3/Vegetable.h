#pragma once
#ifndef VEGETABLE_H
#define VEGETABLE_H

#include "Food.h"
#include "Date.h"
class Vegetable: virtual public Food {
private:
	Date expiration;
public: 
	Vegetable() : Food(){
		std::cout << "Vegetable()" << std::endl;
		expiration = Date();
	}
	Vegetable(std::string n, Date e) : Food(n){
		std::cout << "Vegetable(n, e)" << std::endl;
		expiration = e;
	}
	virtual void expireTime() {
		std::cout << "expires on: " + std::to_string(expiration.getDate()) << std::endl;
	}
};
#endif //VEGETABLE_H