#include <iostream>
#include <math.h>
using namespace std;
int main(void) {
	ios_base::sync_with_stdio(false);
	int N, r, c;
	cin >> N >> r >> c;

	int solution = 0;
	int divide = int(pow(2, N - 1));
	int mul = int(pow(4, N - 1));
	for (int i = 0; i < N; i++) {
		solution += (r / divide)*mul * 2 + (c / divide)*mul;
		r %= divide;
		c %= divide;
		divide /= 2;
		mul /= 4;
	}

	cout << solution;
	return 0;
}