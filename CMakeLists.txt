cmake_minimum_required(VERSION 3.25)
project(cattasks)

set(CMAKE_CXX_STANDARD 17)

add_executable(cattasks main.cpp task1/llword.cpp " GroupAnagrams.cpp" task1/ValidAnagram.cpp)
