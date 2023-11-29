#!/bin/bash

# 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。
# words.txt只包括小写字母和 ' ' 。
# 每个单词只由小写字母组成。
# 单词间由一个或多个空格字符分隔。

cat words.txt | tr -s ' ' '\n' | sort | uniq -c| sort -r | awk '{print $2,$1}'

#  # 切割:  tr命令: 用于转换红删除文件中的字符    -s: 缩减连续重复的字符成指定的单个字符
#  cat words.txt | tr -s ' ' '\n'  # 这行命令就是将空格转换为换行符
#  # 统计单词出现次数: uniq命令: 检查及删除文本文件中重复出现的行列,需要和sort结合使用 -c: 在每列旁边显示该行重复出现的次数
#  cat Words.txt | tr -s ' ' '\n' | sort | uniq -c
#  # 排序单词出现次数  sort命令: 用于对文本按行前缀进行排序,默认从上往下升序   -r: 以相反的顺序进行排序
#  cat Words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r
#  # 打印  awk命令
#  cat words.txt | tr -s ' ' '\n' | sort | uniq -c| sort -r | awk '{print $2,$1#} '


