# encrypdecryp

### How to use
![Alt Text](https://i.imgur.com/3BOwgd0.gif)

## examples
    -mode enc/dec | -alg unicode/shift | -data or -in and -out
1.  java Main -mode enc -in a.txt -out b.txt -key 5 -alg unicode
    - This command must get data from the file a.txt, encrypt the data with the key 5, create a file called b.txt and write ciphertext to it.
2.  java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
    - output: \jqhtrj%yt%m~ujwxpnqq&
3.  java Main -mode dec -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -alg unicode
    - output: Welcome to hyperskill!
