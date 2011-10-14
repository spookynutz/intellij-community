/*
 * Copyright 2000-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package git4idea.repo;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * <p>
 *   Holds information about a remote in Git repository.
 * </p>
 * 
 * <p>
 *   NB: Not all remote preferences (defined in {@code .git/config} are stored in the object.
 *   If some additional data is needed, add the field, getter, constructor parameter and populate it in {@link GitConfig}.
 * </p>
 * 
 * @author Kirill Likhodedov
 */
public final class GitRemote {

  private final String myName;
  private final Collection<String> myUrls;
  private final Collection<String> myPushUrls;
  private final String myFetchRefSpec;
  private final String myPushRefSpec;

  GitRemote(@NotNull String name, @NotNull Collection<String> urls, @NotNull Collection<String> pushUrls, @NotNull String fetchRefSpec, @NotNull String pushRefSpec) {
    myName = name;
    myUrls = urls;
    myPushUrls = pushUrls;
    myFetchRefSpec = fetchRefSpec;
    myPushRefSpec = pushRefSpec;
  }

  public String getName() {
    return myName;
  }

  public Collection<String> getUrls() {
    return myUrls;
  }

  public Collection<String> getPushUrls() {
    return myPushUrls;
  }

  public String getFetchRefSpec() {
    return myFetchRefSpec;
  }

  public String getPushRefSpec() {
    return myPushRefSpec;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GitRemote gitRemote = (GitRemote)o;

    if (!myFetchRefSpec.equals(gitRemote.myFetchRefSpec)) return false;
    if (!myName.equals(gitRemote.myName)) return false;
    if (!myPushRefSpec.equals(gitRemote.myPushRefSpec)) return false;
    if (!myPushUrls.equals(gitRemote.myPushUrls)) return false;
    if (!myUrls.equals(gitRemote.myUrls)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = myName.hashCode();
    result = 31 * result + myUrls.hashCode();
    result = 31 * result + myPushUrls.hashCode();
    result = 31 * result + myFetchRefSpec.hashCode();
    result = 31 * result + myPushRefSpec.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("GitRemote{myName='%s', myUrls=%s, myPushUrls=%s, myFetchRefSpec='%s', myPushRefSpec='%s'}",
                         myName, myUrls, myPushUrls, myFetchRefSpec, myPushRefSpec);
  }

}
