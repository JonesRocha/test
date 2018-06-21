stage 'Checkout'
 node('master') {
  deleteDir()
  checkout scm
 }

fileExists 'contributors.txt'
