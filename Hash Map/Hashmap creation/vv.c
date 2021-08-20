int power(int a, int b){
    // int t = pow(x,y);
    // return t;
    //agr kaam na kre toh comment hta k uper vala use kr lio
    return pow(x,y);
}
int main(){
    int a,b,c;
    clrscn();
    scanf("%d%d",&a,b);
    c = power(a,b);
    printf("power = %d",c);
    return 0;
}