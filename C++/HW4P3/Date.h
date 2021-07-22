#pragma once


#ifndef DATE_H
#define DATE_H
#include <chrono>
#include <String>
#include <ctime>
#include <iomanip>
class Date {
private:
	 long int MS_SINCE_EPOCH;
public:
	Date() {
		std::chrono::system_clock::time_point tp = std::chrono::system_clock::now();
		std::chrono::system_clock::duration dtn = tp.time_since_epoch();
		MS_SINCE_EPOCH = dtn.count() * std::chrono::system_clock::period::num / std::chrono::system_clock::period::den; // gets current time since epoch in ms
	}

	Date(long int set){
		MS_SINCE_EPOCH = set;
	}

	void setDate(long int set) {
		MS_SINCE_EPOCH = set;
	}

	long int getDate() {
		return MS_SINCE_EPOCH; 
	}
};

#endif //Date.h