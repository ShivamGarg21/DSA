#include<iostream>

#include<vector>

using namespace std;
vector < int > onedfilling(vector < vector < int >> & arr, int s) {
    int n = 0;
    int imin = s - 1;
    int imax = arr.size() - s;
    int jmin = s - 1;
    int jmax = arr[0].size() - s;
    int sz = 2*(imax - imin + jmax - jmin);
    vector < int > x(sz, 0);
    for (int i = imin; i <= imax; i++){
        x[n] = arr[i][jmin];
        n++;
    }
    jmin++;

    for (int j = jmin; j <= jmax; j++){
        x[n] = arr[imax][j];
        n++;
    }
    imax--;

    for (int i = imax; i >= imin; i--){
        x[n] = arr[i][jmax];
        n++;
    }
    jmax--;

    for (int j = jmax; j >= jmin; j--){
        x[n] = arr[imin][j];
        n++;
    }
    return x;
}
void shellfilling(vector < vector < int >> & arr, vector < int > & ar, int s) {
    int n = 0;
    int imin = s - 1;
    int imax = arr.size() - s;
    int jmin = s - 1;
    int jmax = arr[0].size() - s;

    for (int i = imin; i <= imax; i++){
        arr[i][jmin] = ar[n];
        n++;
    }
    jmin++;

    for (int j = jmin; j <= jmax; j++){
        arr[imax][j] = ar[n];
        n++;
    }
    imax--;

    for (int i = imax; i >= imin; i--){
        arr[i][jmax] = ar[n];
        n++;
    }
    jmax--;

    for (int j = jmax; j >= jmin; j--){
        arr[imin][j] = ar[n];
        n++;
    }
}
void reverse(vector < int > & ar, int si, int ei) {
    while (si < ei) {
        int temp = ar[si];
        ar[si] = ar[ei];
        ar[ei] = temp;
        si++;
        ei--;
    }
}
void rotate(vector < int > & ar, int r) {
    r %= ar.size();
    if (r < 0)
        r += ar.size();
    reverse(ar, 0, ar.size() - 1 - r);
    reverse(ar, ar.size() - r, ar.size() - 1);
    reverse(ar, 0, ar.size() - 1);
}

void display(vector < vector < int >> & arr) {
    for (int i = 0; i < arr.size(); i++) {
        for (int j = 0; j < arr[0].size(); j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}
void ring_rotate(vector < vector < int >> & arr, int s, int r) {
    vector < int > ar = onedfilling(arr, s);
    rotate(ar, r);
    shellfilling(arr, ar, s);
}
int main() {
    int n, m, s, r;
    cin >> n >> m;
    vector < vector < int >> arr(n, vector < int > (m, 0));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }
    cin >> s >> r;
    ring_rotate(arr, s, r);
    display(arr);
}