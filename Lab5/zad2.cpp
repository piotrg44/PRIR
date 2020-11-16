#include <iostream>
#include <math.h>
#include <ctime>
#include <unistd.h>


	double ObliczPi(int n){
	double suma = 0;
	double ulamek;
		for (int i = 1; i <= n; i++){
			ulamek = pow(-1, i-1) / (2 * i - 1);
			suma += ulamek; 
		}
	return 4*suma;
	}
int main()
{
    int p;
    std::cout<<"Podaj ile procesow: " <<std::endl;
    std::cin>>p;
    
    for(int i = 0; i < p ; i++){
    	if(fork() ==0){
    		srand(time(NULL) ^ (getpid() << 16));
    		int x = (rand() % (400)) + 100;
    		std::cout<<"Dla x = "<<x<<" pi wynosi: " <<ObliczPi(x)<<"\n";
    	}
    	
    }
    return 0;
    
}
