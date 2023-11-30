#!/bin/bash
#题目
#给定一个文件 file.txt，转置它的内容。
#你可以假设每行列数相同，并且每个字段由 ' ' 分隔。


#完整代码
cols=$(head -n 1 file.txt | wc -w)
for i in $(seq 1 $cols); do
    # 获取第i列，然后用paste合并
    cut -d ' ' -f"$i" file.txt | paste -s -d' ' -
done
paste -s head -n
#cols=$(head -n 1 file.txt | wc -w)：
#   head -n 1 file.txt： 提取文件 file.txt 的第一行。
#   wc -w：              统计单词数，这里用于获取第一行有多少列（以空格为分隔符）。
#   cols=：              将列数赋给变量 cols。

# for i in $(seq 1 $cols); do：
#   这是一个 for 循环，用于迭代从 1 到列数 cols 的所有数字。 $i 是循环变量。

#cut -d ' ' -f"$i" file.txt：
#   cut -d ' ' -f"$i"：使用 cut 命令从文件中提取指定列的内容。
#     -d ' '：   指定分隔符为空格。
#     -f"$i"：   指定要提取的列数，由循环变量 $i 控制。

#| paste -s -d' ' -：
#   |：管道符，将前一个命令的输出传递给下一个命令。
#   paste -s -d' ' -：用 paste 命令进行列的合并。
#       -s：   串联行而不是列。
#       -d' '：指定连接时的分隔符为空格。
#        -：   表示从标准输入读取数据。

#作者：Aronic
#链接：https://leetcode.cn/problems/transpose-file/solutions/2438993/shi-yong-cutpastejian-dan-gao-ding-wu-xu-zsp4/
#来源：力扣（LeetCode）
#著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。