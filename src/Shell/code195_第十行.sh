#!/bin/bash
#NR表示awk处理的当前行号。
awk 'NR == 10' file.txt
#tail+head，用tail命令输出文件的第10行及之后的所有行，再将结果通过管道传递给head命令。head命令只保留第一行并输出。
tail -n +10 file.txt | head -1
#sed，-n选项取消sed默认的输出，'10p'指定只打印第10行。
sed -n '10p' file.txt